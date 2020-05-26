package com.training.game.controller;

import com.training.game.entity.Location;
import com.training.game.entity.Monster;
import com.training.game.service.LocationService;
import com.training.game.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;
    @Autowired
    MonsterService monsterService;

    @GetMapping ("locations/{heroId}")
    public String getCurrentLocation (Model model, @PathVariable (name = "heroId") Long heroId){
        return "if current location is null get list locations";
    }

 //   @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping ("admin/locations")
    public String getAllLocations (Model model){
        model.addAttribute("locations", locationService.findAllLocation());
     return "admin/locations";
    }

    @GetMapping  ("admin/edit/{locationId}")
    public String editLocation (Model model, @PathVariable (name = "locationId") Long locationId){
        Location location = locationService.findById(locationId);
        List<Monster> locationMonsters = location.getMonsters();
        List<Monster> allMonsters = monsterService.findAllByLocationNull();
        model.addAttribute("location", location);
        model.addAttribute("locationMonsters",locationMonsters);
        model.addAttribute("allMonsters",allMonsters);
        return "admin/edit";
    }

    @GetMapping ("admin/edit/add/{locationId}/{monsterId}")
    public String addMonster (Model model,
                              @PathVariable (name = "locationId") Long locationId,
                              @PathVariable (name = "monsterId") Long monsterId,
                              @RequestParam (value = "gang") int gang){
        Location location = locationService.findById(locationId);
        Monster monster = new Monster(monsterService.findById(monsterId));
        monster.setId(null);
        monster.setGang(gang);
        location.addMonster(monster);
        locationService.save(location);

        return "redirect:/admin/edit/{locationId}";

    }
    @GetMapping ("admin/edit/remove/{locationId}/{monsterId}")
    public String removeMonster (Model model,
                              @PathVariable (name = "locationId") Long locationId,
                              @PathVariable (name = "monsterId") Long monsterId){
        Location location = locationService.findById(locationId);
        location.removeMonster(monsterService.findById(monsterId));
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }
    @GetMapping ("admin/create")
    public String createNewLocation (Model model){
        locationService.save(new Location("New"));
        return "redirect:/admin/locations";
    }
    @GetMapping ("admin/remove/{locationId}")
    public String removeLocation (Model model, @PathVariable (name = "locationId") Long locationId){
        locationService.deleteById(locationId);
        return "redirect:/admin/locations";
    }

    @GetMapping ("admin/edit/set-ready-true/{locationId}")
    public String setReadyTrue (Model model, @PathVariable (name = "locationId") Long locationId){
        Location location = locationService.findById(locationId);
        location.setReady(true);
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }

    @GetMapping ("admin/edit/set-ready-false/{locationId}")
    public String setReadyFalse (Model model, @PathVariable (name = "locationId") Long locationId){
        Location location = locationService.findById(locationId);
        location.setReady(false);
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }
    @GetMapping ("admin/edit/change-name/{locationId}")
    public String changeName (Model model,
                               @PathVariable (name = "locationId") Long locationId,
                               @RequestParam (name = "name") String name){
        Location location = locationService.findById(locationId);
        location.setName(name);
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }
    @GetMapping ("admin/edit/change-picture/{locationId}")
    public String changePicture (Model model,
                              @PathVariable (name = "locationId") Long locationId,
                              @RequestParam (name = "picture") String picture) {
        Location location = locationService.findById(locationId);
        location.setPictureURL(picture);
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }

    @GetMapping ("admin/edit/set-min-level/{locationId}")
    public String setMinLevel (Model model,
                               @PathVariable (name = "locationId") Long locationId,
                               @RequestParam (name = "min-level") int minLevel){
        Location location = locationService.findById(locationId);
        location.setMinLevel(minLevel);
        locationService.save(location);
        return "redirect:/admin/edit/{locationId}";
    }
}
