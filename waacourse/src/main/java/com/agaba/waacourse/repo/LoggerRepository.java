package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository <Logger, Long>  {
}
