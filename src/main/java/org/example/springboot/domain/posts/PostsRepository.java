package org.example.springboot.domain.posts;
// DAO Data Access Object DB Layer 접근자

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity 클래스, PK타입> 을 상속할 시 CRUD 메소드 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long>{

}

