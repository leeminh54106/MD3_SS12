package com.example.categoryproduct.controller;

import com.example.categoryproduct.model.Category;
import com.example.categoryproduct.service.ICategoryService;
import com.example.categoryproduct.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name ="categoryController", value ="/category-servlet")
public class CategoryController extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("action: " + action);
        if (action == null) {
            action ="";
        }
        switch (action) {
            case "add":
                req.getRequestDispatcher("/categories/addCategory.jsp").forward(req, resp);
                break;
            case "edit":
            {
                Long categoryId = Long.parseLong(req.getParameter("categoryId"));
                Category category = categoryService.findCategoryById(categoryId);
                req.setAttribute("category", category);
                req.getRequestDispatcher("/categories/editCategory.jsp").forward(req, resp);
                break;
            }

            case "delete":
            {
                Long categoryId = Long.parseLong(req.getParameter("categoryId"));
                categoryService.deleteCategoryById(categoryId);
                listCategory(req, resp);
                break;
            }
            case "detail":
            {
                Long categoryId = Long.parseLong(req.getParameter("categoryId"));
                req.setAttribute("categoryDetail", categoryService.findCategoryById(categoryId));
                req.getRequestDispatcher("/categories/detailCategory.jsp").forward(req, resp);
            }
            default:
                listCategory(req, resp);
        }


    }

    private void listCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = CategoryServiceImpl.categories;
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/categories/listCategory.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action ="";
        }
        switch (action) {
            case "add":
            {
                String categoryName = req.getParameter("categoryName");
                boolean categoryStatus = Boolean.parseBoolean(req.getParameter("categoryStatus"));
                Category category = new Category();
                category.setCategoryName(categoryName);
                category.setCategoryStatus(categoryStatus);
                categoryService.addCategory(category);
                // c1: gọi lại listProduct để nó hiển thị
                //listCategory(req, resp);
                // c2: sendRedirect là method get
                resp.sendRedirect("/category-servlet");
                break;
            }
            case "edit":
            {
                Long categoryId = Long.parseLong(req.getParameter("categoryId"));
                String categoryName = req.getParameter("categoryName");
                boolean categoryStatus = Boolean.parseBoolean(req.getParameter("categoryStatus"));
                Category category = new Category();
                category.setCategoryId(categoryId);
                category.setCategoryName(categoryName);
                category.setCategoryStatus(categoryStatus);
                categoryService.updateCategory(category);
                // c1: gọi lại listProduct để nó hiển thị
                //listCategory(req, resp);
                // c2: sendRedirect là method get
                resp.sendRedirect("/category-servlet");
                break;
            }
            case "search":
            {
                String search =  req.getParameter("search");
                List<Category> categories = categoryService.searchCategory(search);
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/categories/listCategory.jsp").forward(req, resp);
                break;
            }
            default:
                listCategory(req, resp);
        }
    }
}
