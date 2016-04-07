package com.epam.entity;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> library_ = null;

	public ArrayList<Book> getLibrary() {
		return library_;
	}

	public void setLibrary(Book book) {
		library_.add(book);
		this.library_ = library_;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Library library = (Library) obj;
		if (null == library_) {
			return (library_ == library.library_);
		} else {
			if (!library_.equals(library.library_)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (int) (((null == library_) ? 0 : library_.hashCode()));
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + "tittle: " + library_;
	}

}
