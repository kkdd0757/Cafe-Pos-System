package service;

import model.Category;
import repository.CategoryRepository;

public class CategoryService {
	final CategoryRepository categoryRepository;
	
	public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public void save(Category category) {
		categoryRepository.join(category);
	}
}
