package com.hotel.repositories;

import com.hotel.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Component - najbardziej ogólny, może być stosowany do Bean-ów będącymi mapperami, narzędziami
 * @Repository - warstwa bazodanowa
 * @Service - logika biznesowa
 * @Controller - warstwa prezentacji 'WEB'
 * @RestController - warstwa prezentacji 'JSON'
 */
@Repository // nadmiarowe ponieważ implementacja domyślna interfejsu jest juz oznaczona jako @Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
