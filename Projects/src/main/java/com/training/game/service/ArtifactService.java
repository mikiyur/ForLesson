package com.training.game.service;

import com.training.game.entity.Artifact;
import org.springframework.stereotype.Service;


public interface ArtifactService {
    Artifact save (Artifact artifact);
    Artifact findById (Long id);
}
