package com.example.lostaktguide.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchCatalogDataCallback {
        void onCatalogDataFetched(boolean error);
    }

    interface GetTypeCallback {
        void setClassList(List<ClassItem> classes);
    }

    interface GetSubClassCallback {
        void setSubClass(SubClassItem subClasses);
    }

    interface GetUserListCallback {
        void setUserList(List<UserItem> user);
    }

    interface GetFavoriteCallback {
        void setFavorite(FavoriteItem favorite);
    }



/*


    void loadCatalog(
            boolean clearFirst, GuideRepository.FetchCatalogDataCallback callback);

    void getProductList(
            CategoryItem category, GuideRepository.GetProductListCallback callback);

    void getProductList(
            int categoryId, GuideRepository.GetProductListCallback callback);

    void getProduct(int id, GuideRepository.GetProductCallback callback);
    void getCategory(int id, GuideRepository.GetCategoryCallback callback);
    void getCategoryList(GuideRepository.GetCategoryListCallback callback);

    void deleteProduct(
            ProductItem product, GuideRepository.DeleteProductCallback callback);

    void updateProduct(
            ProductItem product, GuideRepository.UpdateProductCallback callback);

    void deleteCategory(
            CategoryItem category, GuideRepository.DeleteCategoryCallback callback);

    void updateCategory(
            CategoryItem category, GuideRepository.UpdateCategoryCallback callback);*/
}
