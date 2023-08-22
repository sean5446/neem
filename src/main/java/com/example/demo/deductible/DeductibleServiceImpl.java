package com.example.demo.deductible;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeductibleServiceImpl implements DeductibleService {

    @Autowired
    private DeductibleRepository deductibleRepository;

    // @Transactional - we can remove since jpaRepository provides this functionality

    @Override
    public List<Deductible> findAll() {
        return deductibleRepository.findAll();
    }

    @Override
    public Deductible findById(int id) {
        Optional<Deductible> result = deductibleRepository.findById(id);

        Deductible deductible = null;
        if (result.isPresent()){
            deductible = result.get();
        }
        else {
            throw new RuntimeException("Did not find deductible id: " + id);
        }

        return deductible;
    }

    @Override
    public void save(Deductible deductible) {
        deductibleRepository.save(deductible);
    }

    @Override
    public void deleteById(int id) {
        deductibleRepository.deleteById(id);
    }

    @Override
    public List<Deductible> findByInsuranceId(int id) {
        List<Deductible> deductibles = deductibleRepository.findAll();
        return deductibles.stream().filter(d -> d.getInsuranceId().equals(id)).collect(Collectors.toList());
    }
}