package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Event;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
