package com.libraryManagement;

import java.util.*;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Member {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                if (book.isAvailable()) {
                    System.out.println("Book ID: " + book.getBookId() +
                            ", Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor());
                }
            }
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            System.out.println("Registered Members:");
            for (Member member : members) {
                System.out.println("Member ID: " + member.getMemberId() +
                        ", Name: " + member.getName());
            }
        }
    }

    public void borrowBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        if (member == null) {
            System.out.println("Invalid member ID.");
        } else if (book == null) {
            System.out.println("Invalid book ID.");
        } else if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
        } else {
            member.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        }
    }

    private Book getBookById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Member getMemberById(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void returnBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        if (member == null) {
            System.out.println("Invalid member ID.");
        } else if (book == null) {
            System.out.println("Invalid book ID.");

}
	}
}