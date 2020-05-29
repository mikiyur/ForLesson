package com.training.game.controller;

import com.training.game.entity.HeroClass;
import com.training.game.service.HeroClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeroClassController {
    @Autowired
    private HeroClassService heroClassService;

    @GetMapping("admin/hero-classes")
    public String getHeroClasses(Model model) {
        model.addAttribute("heroClasses", heroClassService.findAll());
        return "admin/hero-classes";
    }

    @GetMapping("admin/create-hero-class")
    public String createHeroClass() {
        heroClassService.save(new HeroClass());
        return "redirect:/admin/hero-classes";
    }

    @GetMapping("admin/remove-hero-class/{heroClassId}")
    public String removeHeroClass(@PathVariable(name = "heroClassId") Long heroClassId) {
        heroClassService.removeById(heroClassId);
        return "redirect:/admin/hero-classes";
    }

    @GetMapping("admin/edit-hero-class/{heroClassId}")
    public String editHeroClass(Model model, @PathVariable(name = "heroClassId") Long heroClassId) {
        model.addAttribute("heroClass", heroClassService.findById(heroClassId));
        return "admin/edit-hero-class";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-name/{heroClassId}")
    public String changeNameHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                      @RequestParam(name = "name") String name) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setName(name);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-picture/{heroClassId}")
    public String changePictureHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                         @RequestParam(name = "picture") String picture) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setPictureURL(picture);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-health/{heroClassId}")
    public String changeMaxHealthPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                        @RequestParam(name = "maxHealthPerSkillPoint") float maxHealthPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setMaxHealthPerSkillPoint(maxHealthPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-mana/{heroClassId}")
    public String changeMaxManaPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                      @RequestParam(name = "maxManaPerSkillPoint") float maxManaPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setMaxManaPerSkillPoint(maxManaPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-power/{heroClassId}")
    public String changePowerPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                    @RequestParam(name = "powerPerSkillPoint") float powerPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setPowerPerSkillPoint(powerPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-spell-power/{heroClassId}")
    public String changeSpellPowerPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                         @RequestParam(name = "spellPowerPerSkillPoint") float spellPowerPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setSpellPowerPerSkillPoint(spellPowerPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-defence/{heroClassId}")
    public String changeDefencePerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                      @RequestParam(name = "defencePerSkillPoint") float defencePerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setDefencePerSkillPoint(defencePerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-critical-attack/{heroClassId}")
    public String changeCriticalAttackPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                             @RequestParam(name = "criticalAttackPerSkillPoint") float criticalAttackPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setCriticalAttackPerSkillPoint(criticalAttackPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-change-chance-critical-attack/{heroClassId}")
    public String changeChanceCriticalAttackPerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                                   @RequestParam(name = "chanceCriticalAttackPerSkillPoint") float chanceCriticalAttackPerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setChanceCriticalAttackPerSkillPoint(chanceCriticalAttackPerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }

    @GetMapping("admin/edit-hero-class/hero-class-chance-dodge/{heroClassId}")
    public String changeChanceDodgePerSkillPointHeroClass(@PathVariable(name = "heroClassId") Long heroClassId,
                                                          @RequestParam(name = "chanceDodgePerSkillPoint") float chanceDodgePerSkillPoint) {
        HeroClass heroClass = heroClassService.findById(heroClassId);
        heroClass.setChanceDodgePerSkillPoint(chanceDodgePerSkillPoint);
        heroClassService.save(heroClass);
        return "redirect:/admin/edit-hero-class/{heroClassId}";
    }
}
