package by.javaeducation.web;

import by.javaeducation.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ItemServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ItemServlet.class);
    private ConfigurableApplicationContext springContext;
    private ItemRestController controller;

    @Override
    public void init() throws ServletException {
        super.init();
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        controller = springContext.getBean(ItemRestController.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item(req.getParameter("title"),
                LocalDateTime.parse(req.getParameter("delivery")),
                Integer.valueOf(req.getParameter("quantity")), false);
        if (req.getParameter("id").isEmpty()) {
            controller.create(item);
        } else {
            item.setId(getId(req));
            controller.update(item);
        }
        resp.sendRedirect("items");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(req);
                controller.delete(id);
                resp.sendRedirect("items");
                break;
            case "create":
            case "update":
                final Item item = "create".equals(action) ?
                        new Item("", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), 10, false) :
                        controller.get(getId(req));
                req.setAttribute("item", item);
                req.getRequestDispatcher("itemForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                req.setAttribute("items", controller.getAll());
                req.getRequestDispatcher("/items.jsp").forward(req, resp);
                break;

        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }
}
