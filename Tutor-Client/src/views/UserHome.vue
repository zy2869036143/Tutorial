<template>
  <div class="menu" style="background: red">
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select="handleSelect">
    <el-menu-item index="1">
      <el-avatar
        :src="avatar">
      </el-avatar>
    </el-menu-item>
     <el-menu-item index="2">
          {{name}}
     </el-menu-item>
    <el-sub-menu index="3">
      <template #title>
        我的空间
      </template>
      <el-sub-menu index="3-1">
        <template #title>个人信息</template>
        <el-menu-item index="3-1-1" @click="toUser()">查看信息</el-menu-item>
        <el-menu-item index="3-1-2" @click="toEditPass()">修改密码</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-sub-menu index="4">
      <template #title>
        我的文章
      </template>
      <el-menu-item index="4-1" @click="toRelease()">发布文章</el-menu-item>
    </el-sub-menu>

    <el-menu-item index="5" v-show="current" @click="toPicture()">
      轮番图
    </el-menu-item>

    <el-menu-item index="6">
        文章总数: {{articals.length}}
    </el-menu-item>

  </el-menu>
  
  </div>
  <div class="card-container">
    <ul  class="cards">
      <li  class="cards__item"  v-for='(article, index) in articals' :key="index"> 
          <div class="card" @click='toEdit(article.id)'>
            <div
              :style= "'background-image:url('+article.banner+')'"
              class="card__image card__image--fence" >
            </div>
            <div class="card__content">
            <div class="card__title">{{article.title}}</div>
            <p class="card__text">{{"________________________________________________________________________\n"+article.description}}</p>
            <button class="btn btn--block card__btn">查看文章</button>
          </div>
        </div>
      </li>
    </ul>
  </div>

</template>

<script>
import { mapState } from 'vuex'
import { getBriefInf, getUserInfor} from "../services"
import {
  //Location,
  ////Document,
  //Menu as IconMenu,
  //Setting,
} from '@element-plus/icons-vue'

export default {
    name: "UserHome",
    data(){
      return{
        current: false, 
        uid : 0,
        name: "",
        avatar: "",
        gender: '',  
        account : "",
        isCollapse : true,
        articals: [],
      }
    },
    computed: {
      ...mapState([
        'account', 'jwtToken', 'id'
      ])  
    },  
    created(){
      this.uid = this.$route.params.id;
      this.getData();
      this.getUser();
    },
    components:{
      //Location,
      // Document,
      //IconMenu,
      // Setting,
    },
    methods:{
      toPicture(){
        this.$router.push("/picture");        
      },
      toArtical(){
        this.$router.push("/artical");
      },
      getData(){
        getBriefInf(this.uid).then(res =>{
          if(res.code == 200){
            this.articals = res.data;
          }
        })
      },
      toEdit(articleId){
        this.$router.push("/article/edit/"+articleId);
      },
      toRelease(){
        this.$router.push("/release");
      },
      toUser(){      
        this.$router.push(`/userInfor/${encodeURIComponent(JSON.stringify(this.uid))}`);
      },
      toEditPass(){
        this.$router.push('/editPassword');
      },
      getUser(){
        getUserInfor(this.id).then(res =>{
          this.account = res.data.account;
          this.name = res.data.name;
          this.avatar = res.data.avatar;
          if(this.account == "202000300021"){
            this.current = true;
          }
        })
      }
    },
}
</script>

<style scoped>
.menu-aside,.menu{
  background: red;
  max-width: 170px;
  height: 100%;
  display: inline;
}
.card-container{
  display: inline;
  background: rebeccapurple;
}
/* li{
  width: 600px;
} */
.cards {
  display: flex;
  flex-wrap: wrap;
  list-style: none;
  margin: 0;
  padding: 0;
}
.artical:hover{
  box-shadow: 0 10px 50px 10px rgb(134, 134, 134);
}


*,
*::before,
*::after {
  box-sizing: border-box;
}
img {
  height: auto;
  max-width: 100%;
  vertical-align: middle;
}
.btn {
  background-color: white;
  border: 1px solid #cccccc;
  color: #696969;
  padding: 0.5rem;
  text-transform: lowercase;
}
.btn--block {
  display: block;
  width: 100%;
}

.cards__item {
  display: flex;
  padding: 1rem;
}
@media (min-width: 40rem) {
  .cards__item {
    width: 50%;
  }
}
@media (min-width: 56rem) {
  .cards__item {
    width: 33.3333%;
  }
}
.card {
  background-color: white;
  border-radius: 0.25rem;
  box-shadow: 0 20px 40px -14px rgba(0, 0, 0, 0.25);
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.card:hover{
    box-shadow: 0 10px 50px 10px rgb(92, 91, 91);

}
.card:hover .card__image {
  filter: contrast(100%);
}
.card__content {
  display: flex;
  flex: 1 1 auto;
  flex-direction: column;
  padding: 1rem;
}
.card__image {
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
  border-top-left-radius: 0.25rem;
  border-top-right-radius: 0.25rem;
  filter: contrast(70%);
  overflow: hidden;
  position: relative;
  transition: filter 0.5s cubic-bezier(0.43, 0.41, 0.22, 0.91);
}
.card__image::before {
  content: "";
  display: block;
  padding-top: 56.25%;
}
@media (min-width: 40rem) {
  .card__image::before {
    padding-top: 66.6%;
  }
}
.card__title {
  color: #696969;
  font-size: 1.25rem;
  font-weight: 300;
  letter-spacing: 2px;
  text-transform: uppercase;
}
.card__text {
  flex: 1 1 auto;
  font-size: 0.875rem;
  line-height: 1.5;
  margin-bottom: 1.25rem;
}
</style>