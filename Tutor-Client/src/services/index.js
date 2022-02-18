import axios from "axios";
import { store } from "@/store/createStore.js"

var BASE_URL = "http://localhost:9090/api"
function userLoginReq(account, password){
    return axios.post(
        BASE_URL + "/login",
        {
            "account": account,
            "password": password
        }
    ).then(res => {
        return res.data
    })
}
function getBriefInf(id){
    return axios.post(
        BASE_URL + "/blog/briefInf",
        {
            "userId": id
        },
        {
            headers: {
                Authorization: store.state.jwtToken
            }
        }
    ).then(
        res => {
            return res.data
        }
    )
}
function blogEdit(blog){
    return axios.post(
        BASE_URL + "/blog/edit",
        blog,
        {
            headers: {
                Authorization: store.state.jwtToken
            }
        }
    ).then(
        res => {
            return res.data
        }
    )
}

function postBlogById(blogId){
    return axios.post(
        BASE_URL + "/blog/pget",
        {
            "blogId": blogId
        },
        {
            headers: {
                Authorization: store.state.jwtToken
            }
        }
    ).then(
        res => {
            return res.data
        }
    )
}
function getBlogById(blogId){
    return axios.get(BASE_URL+"/blog/get",
    {
        params: {
            id: blogId
        }
    }).then(res =>{
        return res.data;
    })
}

function deleteBlog(blogId, userId){
    return axios.post(BASE_URL+"/blog/delete",
    {
        "blogId": blogId,
        "userId": userId
    },
    {
        headers: {
            Authorization: store.state.jwtToken
        }
    }).then(res =>{
        return res.data;
    })
}


function getUserInfor(userId){
    return axios.post(BASE_URL+"/userInf",
    {
        "userId": userId
    },
    {
        headers: {
            Authorization: store.state.jwtToken
        }
    }).then(res =>{
        return res.data;
    })
}

function editPassword(userId, oldPass, newPass){
    return axios.post(BASE_URL+"/editPassword",
    {
        "userId": userId,
        "oldPassword": oldPass,
        "newPassword": newPass
    },
    {
        headers: {
            Authorization: store.state.jwtToken
        }
    }).then(res =>{
        return res.data;
    })
}



function updateUserInf(user){
    return axios.post(BASE_URL+"/update",
    user,
    {
        headers: {
            Authorization: store.state.jwtToken
        }
    }).then(res =>{
        return res.data;
    })
}

function getBlogByType(type){
    return axios.get(BASE_URL+"/blog/getType",
    {
        params: {
            type: type
        }
    }).then(res =>{
        return res.data;
    })
}

function getPictures(){
    return axios.get(BASE_URL+"/picture/get").then(res =>{
        return res.data;
    })
}

function savePictures(array){
    return axios.post(BASE_URL+"/picture/save",
    {
        pictures: array
    },
    {
        headers: {
            Authorization: store.state.jwtToken
        }
    }).then(res =>{
        return res.data;
    })
}

export{
    userLoginReq,
    getBriefInf,
    getBlogById,
    blogEdit,
    postBlogById,
    deleteBlog,
    getUserInfor,
    editPassword,
    updateUserInf,
    getBlogByType,
    getPictures,
    savePictures
}
