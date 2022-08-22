package com.gui.demo.service.impl;

import com.gui.demo.domain.NbaPlayer;
import com.gui.demo.mapper.NbaPlayerMapper;
import com.gui.demo.service.NbaPlayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NbaPlayerServiceImpl implements NbaPlayerService {
    @Resource
    private NbaPlayerMapper nbaPlayerMapper;

    public List<NbaPlayer> ListNbaPlayer() {
        return nbaPlayerMapper.listNbaMapper();
    }

}
