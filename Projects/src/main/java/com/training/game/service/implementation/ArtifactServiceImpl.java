package com.training.game.service.implementation;

import com.training.game.entity.Artifact;
import com.training.game.repository.ArtifactRepository;
import com.training.game.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtifactServiceImpl implements ArtifactService {

    @Autowired
    ArtifactRepository artifactRepository;
    @Override
    public Artifact save(Artifact artifact) {
        return artifactRepository.save(artifact);
    }

    @Override
    public Artifact findById(Long id) {
        return artifactRepository.findById(id).get();
    }
}
