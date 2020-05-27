package com.training.game.controller;

import com.training.game.entity.Location;
import com.training.game.entity.Monster;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonsterController {
    @Autowired
    MonsterService monsterService;

    @GetMapping("admin/monsters")
    public String getAllMonsters (Model model){
        model.addAttribute("monsters", monsterService.findAllByLocationNull());
        return "admin/monsters";
    }
    @GetMapping ("admin/create-monster")
    public String createNewMonster (Model model){
        monsterService.save(new Monster());
        return "redirect:/admin/monsters";
    }
    @GetMapping ("admin/remove-monster/{monsterId}")
    public String removeMonster (Model model, @PathVariable (name = "monsterId") Long monsterId){
        monsterService.removeById(monsterId);
        return "redirect:/admin/monsters";
    }
    @GetMapping ("admin/edit-monster/{monsterId}")
    public String editMonster (Model model, @PathVariable (name = "monsterId") Long monsterId) {
        model.addAttribute("monster", monsterService.findById(monsterId));
        return "admin/edit-monster";
    }

    @GetMapping ("admin/edit-monster/monster-change-name/{monsterId}")
    public String changeNameMonster (Model model,
                                     @PathVariable (name = "monsterId") Long monsterId,
                                     @RequestParam (name = "name") String name) {
        Monster monster = monsterService.findById(monsterId);
        monster.setName(name);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
}
