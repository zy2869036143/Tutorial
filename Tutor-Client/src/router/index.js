import { createRouter, createWebHashHistory } from 'vue-router'
import Logpage from "@/components/Logpage.vue"
import Home from "@/views/Home.vue"
import Upload from "@/views/Uploda.vue"
import UserHome from "@/views/UserHome.vue"
import ArticalEdit from "@/views/ArticalEdit.vue"
import ArticalDetail from "@/views/ArticalDetail.vue"
import UserInfor from "@/views/UserInfor.vue"
import EditPassword from "@/views/EditPassword.vue"
import Picture from "@/views/Picture.vue"
import Tweet from "@/views/Tweet.vue"
import Note from "@/views/Note.vue"
const routes =[
    {
        path:'/login',
        name: 'login',
        component: Logpage
    },
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/upload',
        name: 'upload',
        component: Upload
    },
    {
        path: '/userhome/:id?',
        name: 'UserHome',
        component: UserHome
    },
    {
        path: '/article/edit/:id?',
        name: "ArticleEdit",
        component: ArticalEdit
    },
    {
        path: '/article/:id?',
        name: 'ArticalDetail',
        component: ArticalDetail
    },
    {
        path: '/release',
        name: "Arti1cleEdit",
        component: ArticalEdit
    },
    {
        path: '/userInfor/:id?',
        name: "user",
        component: UserInfor
    },
    {
        path: '/editPassword',
        name: "editPass",
        component: EditPassword
    },
    {
        path: '/picture',
        name: 'pic',
        component: Picture
    },
    {
        path: '/tweet',
        name: 'tweet',
        component: Tweet
    },
    {
        path: '/note',
        name: 'note',
        component: Note
    }
]
const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes,
})
export default router