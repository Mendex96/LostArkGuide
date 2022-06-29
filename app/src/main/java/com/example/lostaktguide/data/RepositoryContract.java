package com.example.lostaktguide.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchClassDataCallback {
        void onTypeDataFetched(boolean error);
    }

    interface FetchUserDataCallback {
        void onUserDataFetched(boolean error);
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



    void loadCatalog(
            boolean clearFirst, FetchClassDataCallback callback);

    void loadUser(
            boolean clearFirst, FetchUserDataCallback callback);

    void getTypeList(GuideRepository.GetTypeCallback callback);

    void getUserList(RepositoryContract.GetUserListCallback callback);


}
