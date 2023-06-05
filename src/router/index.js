import {createRouter} from "vue-router";
import {createWebHashHistory} from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import NotFound from "../views/NotFound.vue";
import ForgetPwd from "../views/ForgetPwd.vue";
import AppLayout from "../views/AppLayout.vue";
import Order from "../views/Order.vue";
import History from "../views/History.vue";
import Show from "../views/Show.vue";
import MovieList from "../views/MovieList.vue";
import FavoriteList from "../views/FavoriteList.vue";
import recommendList from "../views/RecommendList.vue";


const routes = [
    {path: "/", component: Home},
    {path: "/login", component: Login},
    {path: "/register", component: Register},
    {path: "/forgetPwd", component: ForgetPwd},
    // {path: "/movie", component: MovieList},
    {path: "/path(.*)", component: NotFound},
    {
        path: "/AppLayout",
        component: AppLayout,
        children: [
            {
                path: "/recommend",
                name: "/recommend",
                component: recommendList,
            },
            {
                path: "/History",
                name: "/History",
                component: History,
            },
            {
                path: "/movie",
                name: "/movie",
                component: MovieList,
            },
            {
                path: "/Favorite",
                name: "/Favorite",
                component: FavoriteList,
            },
            {
                path: "/Show/:id/:name/:description/:dataSet/:alg",
                name: "/Show",
                component: Show,
            },
        ],
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes,
});

export default router;
