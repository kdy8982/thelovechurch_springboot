package kr.co.thelovechruch_springboot.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT n FROM Notice n ORDER BY n.createdDate desc")
    List<Notice> findAllDesc();
}
