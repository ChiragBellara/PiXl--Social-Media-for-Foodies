package com.PiXl.mainframe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PiXl.mainframe.entities.TagsEntity;


@Repository
public interface TagsRepository extends JpaRepository<TagsEntity, Long>  {
	
	/**
	 * Find a tag by its unique ID.
	 *
	 * @param id the unique identifier of the tag
	 * @return an Optional containing the TagsEntity if found, or an empty Optional if no tag is found with the specified ID
	 */
	Optional<TagsEntity> findByTagId(Long id);

	/**
	 * Retrieve all tags.
	 *
	 * @return a list of all TagsEntity objects available in the repository
	 */
	List<TagsEntity> findAll();

	/**
	 * Find tags whose name contains the specified string, ignoring case.
	 *
	 * @param name the substring to search for in tag names
	 * @return a list of TagsEntity objects whose names contain the specified substring, ignoring case
	 */
	List<TagsEntity> findByNameContainingIgnoreCase(String name);
	
	Optional<TagsEntity> findByNameIgnoreCase(String name);

	/**
	 * Find tags associated with the specified posts.
	 *
	 * @param posts a set of Posts objects to search for associated tags
	 * @return a list of TagsEntity objects that are associated with the given set of posts, ignoring case
	 */
//	List<TagsEntity> findByPostsContainingIgnoreCase(Set<PostsEntity> posts);
	
	/**
	 * Finds the most frequent tags and lists them in descending order
	 * 
	 * @return a list of TagsEntity objects with the highest frequency
	 */
	@Query("SELECT t FROM TagsEntity t ORDER BY SIZE(t.postsForTag) DESC")
	List<TagsEntity> findMostFrequentTags();
	
	/**
	 * Find tags whose name is an exact match to the given tag name
	 * 
	 * @param name
	 * @return a list of TagsEntity objects whose names match exactly the given parameter
	 */
	List<TagsEntity> findAllByNameIgnoreCase(String name);
	
//	List<TagsEntity> findAllByNameContainingIgnoreCase(String name);
	
	Boolean existsByNameIgnoreCase(String name);
	
}
