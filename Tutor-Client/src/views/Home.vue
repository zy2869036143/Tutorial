<template>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <Title></Title>
        
      </div> <!-- .navbar-header -->
      <div class="navbar-right" id="navbar" >
        <ul class="nav navbar-nav navbar-right">
          <li class="kind"><a class="kind">点滴记录</a></li>
          <li class="kind"><a class="kind">支教推文</a></li>
          <li class="kind"><a class="kind">支教笔记</a></li>
          <!-- <li><a href="#" @click="toUpload()">支教日记</a></li> -->
          <li><Button @click="toLoginPage()"></Button></li>
        </ul>
      </div> <!-- .navbar-collapse -->
    </div> <!-- .container -->
  </nav>

  <main data-spy="scroll" data-target=".navbar" data-offset="50">
    <test></test>
    <div class="jumbotron photo-cover text-inverse">
      <div class="col-md-6 text-center center">
       
        <a href="#about">
        <span class="fui-triangle-down large"></span>
        </a>
      </div> <!-- .col-md-6 -->

     
      <div class="second" id="first">
        <div class="dec">
           <p class="section">
          </p>
          <p class="tit">点滴记录</p>
          <p class="shadow">点滴记录</p>
        </div>

       
        <div class="block">
          <el-carousel :interval="4000" 
          type="card" 
          height="620px">
            <el-carousel-item v-for="item in this.pics" :key="item">
              <el-image
                style="width: 960px; height: 620px"
                :src="item">
              </el-image>
              <img style="height: 620px" :src="item" />
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <div class="third" id="second">
         <div class="dec">
           <p class="section">
          </p>
          <p class="tit">支教推文</p>
          <p class="shadow">支教推文</p>

        </div>
        <GlowingButton class="glowing-button" @click="toTweets()"></GlowingButton>
        <Cards class = "frist-card"  v-bind:inPage=getBid @getBid='getThis' ></Cards>
      </div>

      <div class="fourth" id="third">
         <div class="dec">
           <p class="section">
          </p>
          <p class="tit">支教笔记</p>
          <p class="shadow">支教笔记</p>

        </div>
        <GlowingButton class="glowing-button" @click="toNotes()"></GlowingButton>
        <CardsT class="cardT" v-bind:inPage=getBid @getBid='getThis' ></CardsT>
      </div>
    </div> 
  </main>
    <!-- Footer -->
    <footer>
      <div class="bottom-container">
          <div class="row">
              <div class="col-lg-12">
                  <ul class="list-inline">
                      <li>
                          <a>队伍成员</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>徐文森</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a >杨力权</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>秦绍杰</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>孙茹玉</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>蔡千千</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>温宇欣</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>李泽宇</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>孙铭晨</a>
                      </li>
                      <li class="footer-menu-divider">&sdot;</li>
                      <li>
                          <a>冯薪羽</a>
                      </li>
                  </ul>
                  <p class="copyright text-muted small">Copyright &copy; SDU software lzyu. All Rights Reserved</p>
              </div>
          </div>
      </div>
    </footer>
</template>

<script >
import GlowingButton from '@/components/GlowingButton.vue';
import Button from '@/components/Button.vue';
import Cards from '@/components/Cards.vue';
import CardsT from '@/components/CardsT.vue';
import test from '@/components/test.vue';
// import SplitImage from '@/components/SplitImage.vue'
//import Second from '@/components/Second.vue';
import Title from '@/components/Title.vue';
import{getPictures} from "../services"
export default { 
  name: 'home',
  components: {
    GlowingButton,
    Button,
    Cards,
    CardsT,
    test,
    // SplitImage,
    //Second,
    Title,
  },
  mounted(){
    window.addEventListener('scroll', function() {
      var scroll =  $(window).scrollTop();
      if (scroll > window.innerHeight - 55) {
          $(".navbar").addClass("transparent");
          $("main").addClass=("bg-pic2");
        } else {
          $(".navbar").removeClass("transparent");
      }
      // if (delta < 0) {
      //   this.alert("!!!");
      //   $(".navbar").removeClass("transparent");

      // } else {
      //           this.alert(delta);

      // }
    })
  },
  data(){
    return {
        getBid: 0,
        bg : "bio",
        pics : [],
        fits : ['fill', 'contain', 'cover', 'none', 'scale-down'],
        pictures : [require("@/static/pic1.png"), require("@/static/pic2.png"), require("@/static/pic3.png"), require("@/static/pic4.png")]
    }
  },
  created(){
      this.pageGetPic();
  },
  methods:{
      toTweets(){
        this.$router.push("/tweet");
      },
      toNotes(){
        this.$router.push("/note");
      },
      toLoginPage(){
        this.$router.push("/login");
      },
      // toUpload(){
      //   console.log("touser")
      //   this.$router.push('/userhome:1')
      // },
      getThis(bid){
        if(bid!=0){
          this.$router.push('/article/'+bid);
        }
      },
      pageGetPic(){
        getPictures().then(res =>{
          console.log("res:")
          console.log(res)
          var item = res.data;
          for(var i=0; item[i]!=null  ; ++i){
            this.pics.push(item[i].url);
          }
        })
      }
  }
}
</script>

<style scoped>
.section{
  background: rgba(94,101,108,0.8);
  height: 40%;
  grid-row: 1;
  grid-column: 2;
  /* transform: translate(-70%,-100%); */
  transform: skewX(-45deg);
}
.tit{
  grid-row: 1;
  grid-column: 2;
  z-index: 10;
}
.shadow{
  grid-row: 1;
  grid-column: 2;
  z-index: 8;
  color: black;
  transform: skewX(-45deg) translate(3%);;

}
.dec{
  margin-bottom: 5%;
  margin-top: 9%;
  display: grid;
  height: 40%;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 10px;
  grid-auto-rows: minmax(100px, auto);
  background: rgba(67,87,172,0.7);
}

ul li {
  display: inline;
  text-align: center;
  margin-right: 20px;
}
a{
  color: white;
  text-decoration: none;
} 
.col-md-6{
  height: 700px;
}
.navbar-header{
  display: inline;
  padding-left: 3%;
}
.navbar-toggle{
  background: transparent;
}
.block{
    width: 100%
}


@media screen and (max-width: 960px){
  .navbar-right{
    display: none;
  }
}

@media screen and (min-width: 960px){

.navbar-right{
  float: right;
  margin: 0;
  width: 500px;
  display: inline;
}
}
.nav{
  position: absolute;
}
.navbar{
  margin-top: 0;
  padding-top: 1%;
  position: fixed;
  height: 4.2rem;
  width: 100%;
  z-index: 10;
}
.second{
  width: 100%;
  height: 900px;
}
h1,p {
  color: white;
  text-align: center;
  vertical-align: middle;
}
.jumbotron {
  margin-top: 0;
}
.jumbotron , p{
  padding-top: 150px;
  padding-bottom: 150px;
  margin-bottom: 0;
}
main {
  background: #34495e url(https://static.pexels.com/photos/36487/above-adventure-aerial-air-large.jpg) no-repeat center / cover fixed;
  z-index: 0;
  position: abosolute;
} 

.transparent {
  background: rgb(90,116,237);
  background: linear-gradient(90deg, rgba(90,116,237,0.7063200280112045) 0%, rgba(94,101,108,1) 100%);
}
.second{
  text-align: center;
}
.kind:hover{
  color: aqua;
}
h1 {
  font-size: 50px;
}
p{
  font-size: 30px;
}
.glowing-button{
  /* float: right;  */
  margin-top: 2%;
  margin-left: 78%;
}
.frist-card{
  margin-top: 4%;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.bottom-container{
  text-align: center;
  background: rgb(90,116,237);
  background: linear-gradient(90deg, rgba(90,116,237,0.9416141456582633) 0%, rgba(94,101,108,1) 100%);}
.third{
  margin-top: 15%;
}
.list-inline{
  margin-top: 0%;
  padding-top: 8%;
  font-size: 20px;
}

</style>
