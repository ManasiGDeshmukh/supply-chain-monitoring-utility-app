package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Entity.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    List<Track> getAllTrack();
    Optional<Track> getTrackById(Long id);
    Track saveTrack(Track track);
    void deleteTrack(Long id);
}
