package org.hms.adminservice.repository;

import org.hms.adminservice.document.RegDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegRepository extends MongoRepository<RegDoc, String> {

    void deleteByEmail(String email);

    Optional<RegDoc> findByEmail(String s);
}
