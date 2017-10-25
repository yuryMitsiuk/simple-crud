package by.javaeducation.web;

import by.javaeducation.model.Item;
import by.javaeducation.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping(value = "/items")
    public String items(Model model) {
        model.addAttribute("items", service.getAll());
        return "items";
    }

    @GetMapping(value = "items/create")
    public String create(Model model) {
        model.addAttribute("item", new Item("", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), 10, false));
        return "itemForm";
    }

    @GetMapping(value = "items/delete")
    public String delete(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        service.delete(id);
        return "redirect:/items";
    }

    @GetMapping(value = "items/update")
    public String update(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("id"));
        model.addAttribute("item", service.get(id));
        return "itemForm";
    }

    @PostMapping(value = "/items")
    public String save(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Item item = new Item(id.isEmpty() ? null : Integer.valueOf(id),
                            request.getParameter("title"),
                            LocalDateTime.parse(request.getParameter("delivery")),
                            Integer.valueOf(request.getParameter("quantity")),
                            false);
        if (item.isNew()) {
            service.save(item);
        } else {
            service.update(item);
        }
        return "redirect:/items";
    }
}
