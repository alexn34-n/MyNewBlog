package com.alexn.mynewblog.repository;

import com.alexn.mynewblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
