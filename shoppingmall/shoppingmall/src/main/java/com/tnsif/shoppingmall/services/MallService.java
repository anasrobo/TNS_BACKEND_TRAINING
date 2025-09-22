package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.Mall;
import com.tnsif.shoppingmall.entity.MallAdmin;
import com.tnsif.shoppingmall.repository.MallRepository;
 import com.tnsif.shoppingmall.repository.MallAdminRepository;

import jakarta.transaction.Transactional;

@Service
public class MallService {

    private final MallRepository mallRepository;
    private final MallAdminRepository mallAdminRepository;

    public MallService(MallRepository mallRepository, MallAdminRepository mallAdminRepository) {
        this.mallRepository = mallRepository;
        this.mallAdminRepository = mallAdminRepository;
    }

    @Transactional
    public Mall save(Mall mall) {
        // Ensure bidirectional linkage with admin if present
        MallAdmin admin = mall.getMallAdmin();
        if (admin != null) {
            // Save admin first to generate ID, then link back
            MallAdmin savedAdmin = mallAdminRepository.save(admin);
            savedAdmin.setMall(mall);
            mall.setMallAdmin(savedAdmin);
        }
        return mallRepository.save(mall);
    }

    public Mall get(long id) {
        return mallRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        mallRepository.deleteById(id);
    }
}
