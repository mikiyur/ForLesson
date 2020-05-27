package com.training.game.controller;

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
    public String getAllMonsters(Model model) {
        model.addAttribute("monsters", monsterService.findAllByLocationNull());
        return "admin/monsters";
    }

    @GetMapping("admin/create-monster")
    public String createNewMonster(Model model) {
        monsterService.save(new Monster());
        return "redirect:/admin/monsters";
    }

    @GetMapping("admin/remove-monster/{monsterId}")
    public String removeMonster(Model model, @PathVariable(name = "monsterId") Long monsterId) {
        monsterService.removeById(monsterId);
        return "redirect:/admin/monsters";
    }

    @GetMapping("admin/edit-monster/{monsterId}")
    public String editMonster(Model model, @PathVariable(name = "monsterId") Long monsterId) {
        model.addAttribute("monster", monsterService.findById(monsterId));
        return "admin/edit-monster";
    }

    @GetMapping("admin/edit-monster/monster-change-name/{monsterId}")
    public String changeNameMonster(Model model,
                                    @PathVariable(name = "monsterId") Long monsterId,
                                    @RequestParam(name = "name") String name) {
        Monster monster = monsterService.findById(monsterId);
        monster.setName(name);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }

    @GetMapping("admin/edit-monster/monster-change-picture/{monsterId}")
    public String changePictureMonster(Model model,
                                       @PathVariable(name = "monsterId") Long monsterId,
                                       @RequestParam(name = "picture") String picture) {
        Monster monster = monsterService.findById(monsterId);
        monster.setPictureURL(picture);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }


    @GetMapping("admin/edit-monster/monster-set-boss-true/{monsterId}")
    public String setBossTrueMonster(Model model,
                                    @PathVariable(name = "monsterId") Long monsterId) {
        Monster monster = monsterService.findById(monsterId);
        monster.setBoss(true);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-set-boss-false/{monsterId}")
    public String setBossFalseMonster(Model model,
                                    @PathVariable(name = "monsterId") Long monsterId) {
        Monster monster = monsterService.findById(monsterId);
        monster.setBoss(false);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-level/{monsterId}")
    public String changeLevelMonster(
                                       @PathVariable(name = "monsterId") Long monsterId,
                                       @RequestParam(name = "level") int level) {
        Monster monster = monsterService.findById(monsterId);
        monster.setLevel(level);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-health/{monsterId}")
    public String changeMaxHealthPointMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "health") float health) {
        Monster monster = monsterService.findById(monsterId);
        monster.setMaxHealthPoint(health);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-mana/{monsterId}")
    public String changeMaxManaPointMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "mana") float mana) {
        Monster monster = monsterService.findById(monsterId);
        monster.setMaxManaPoint(mana);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-power/{monsterId}")
    public String changePowerMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "power") float power) {
        Monster monster = monsterService.findById(monsterId);
        monster.setPower(power);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-spell-power/{monsterId}")
    public String changeSpellPowerMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "spell-power") float spellPower) {
        Monster monster = monsterService.findById(monsterId);
        monster.setSpellPower(spellPower);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-defence/{monsterId}")
    public String changeDefenceMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "defence") float defence) {
        Monster monster = monsterService.findById(monsterId);
        monster.setDefence(defence);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-critical/{monsterId}")
    public String changeCriticalAttackMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "critical") float critical) {
        Monster monster = monsterService.findById(monsterId);
        monster.setCriticalAttack(critical);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-critical-chance/{monsterId}")
    public String changeChanceCriticalAttackMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "critical-chance") float chanceCriticalAttack) {
        Monster monster = monsterService.findById(monsterId);
        monster.setChanceCriticalAttack(chanceCriticalAttack);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }
    @GetMapping("admin/edit-monster/monster-change-dodge-chance/{monsterId}")
    public String changeChanceDodgeMonster(
            @PathVariable(name = "monsterId") Long monsterId,
            @RequestParam(name = "dodge-chance") float chanceDodge) {
        Monster monster = monsterService.findById(monsterId);
        monster.setChanceDodge(chanceDodge);
        monsterService.save(monster);
        return "redirect:/admin/edit-monster/{monsterId}";
    }

    //
    //
}
