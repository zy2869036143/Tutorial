<template>
<div class="wrapper">
	<div class="cols">
		<div v-for="item in size" :key="item" class="col" ontouchstart="this.classList.toggle('hover');">
			<div class="container" @click="toFather(bids[item])">
				<div class="front" :style="'background-image: url('+banners[item]+')'">
					<div class="inner">
						<p>{{titles[item]}}</p>
						<span>{{users[item]}}</span>
					</div>
				</div>
				<div class="back">
					<div class="inner">
						<p>{{descrpitions[item]}}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</template>

<script>
import { getBlogByType} from "../services"
export default {
	data(){
		return{
			articles: [],
			titles: ["占位"],
			users: ["占位"],
			banners: ["占位"],
			descrpitions: ["占位"],
      bids:[0],
      size: 8,
      all: false
		}
	},
	created(){
    if(this.$route.path =="/note"){
        this.all = true;
    }
		this.getType();
	},
	methods:{
    toFather(page) {
        this.clkpage = page;
        this.$emit('getBid',this.clkpage);
    },
		getType(){
			getBlogByType(1).then(res =>{
				this.articles = res.data;
				if(this.all)
          this.size = res.data.length;
				for(var item=0;  item < this.size ; item++){
					if(this.articles[item] != null){
						var blog = this.articles[item];
						this.titles.push(blog.title);
            var user = 0;
            switch(blog.userId){
              case 1:
                user = "李泽宇";
                break;
              case 2:
                user = "孙茹玉";
                break;
              case 3:
                user = "秦绍杰";
                break;
              case 4:
                user = "徐文森";
                break;
              case 5:
                user = "温宇欣";
                break;
              case 6:
                user = "杨力权";
                break;
              case 7:
                user = "孙铭晨";
                break;
              case 8:
                user = "冯薪羽";
                break;
              case 9:
                user = "蔡千千";
                break;
            } 
            this.users.push(user);
						this.banners.push(blog.banner);
            this.bids.push(blog.id);
						this.descrpitions.push(blog.description);
					}else{
						this.titles.push("暂无");
						this.users.push("暂无");
						this.banners.push("https://unsplash.it/503/503/");
						this.descrpitions.push("暂无");
            this.bids.push(0);
					}
				}
				console.log(this.titles);
			})
		}
	}
}
</script>

<style scoped>
*{
  margin: 0;
  padding: 0;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
}

h1{
  font-size: 2.5rem;
  font-family: 'Montserrat';
  font-weight: normal;
  color: #444;
  text-align: center;
  margin: 2rem 0;
}

.wrapper{
  width: 90%;
  margin: 0 auto;
  max-width: 80rem;
}

.cols{
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
      flex-wrap: wrap;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
}

.col{
  width: calc(25% - 2rem);
  margin: 1rem;
  cursor: pointer;
}

.container{
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
	-webkit-perspective: 1000px;
        perspective: 1000px;
}

.front,
.back{
  background-size: cover;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.25);
  border-radius: 10px;
	background-position: center;
	-webkit-transition: -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
	transition: -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
	-o-transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
	transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
	transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1), -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
	-webkit-backface-visibility: hidden;
    backface-visibility: hidden;
	text-align: center;
	min-height: 280px;
	height: auto;
	border-radius: 10px;
	color: #fff;
	font-size: 1.5rem;
}

.back{
  background: #cedce7;
  background: -webkit-linear-gradient(45deg,  #cedce7 0%,#596a72 100%);
  background: -o-linear-gradient(45deg,  #cedce7 0%,#596a72 100%);
  background: linear-gradient(45deg,  #cedce7 0%,#596a72 100%);
}

.front:after{
	position: absolute;
    top: 0;
    left: 0;
    z-index: 1;
    width: 100%;
    height: 100%;
    content: '';
    display: block;
    opacity: .6;
    background-color: #000;
    -webkit-backface-visibility: hidden;
            backface-visibility: hidden;
    border-radius: 10px;
}
.container:hover .front,
.container:hover .back{
    -webkit-transition: -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
    transition: -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
    -o-transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
    transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
    transition: transform .7s cubic-bezier(0.4, 0.2, 0.2, 1), -webkit-transform .7s cubic-bezier(0.4, 0.2, 0.2, 1);
}

.back{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
}

.inner{
    -webkit-transform: translateY(-50%) translateZ(60px) scale(0.94);
            transform: translateY(-50%) translateZ(60px) scale(0.94);
    top: 50%;
    position: absolute;
    left: 0;
    width: 100%;
    padding: 2rem;
    -webkit-box-sizing: border-box;
            box-sizing: border-box;
    outline: 1px solid transparent;
    -webkit-perspective: inherit;
            perspective: inherit;
    z-index: 2;
}

.container .back{
    -webkit-transform: rotateY(180deg);
            transform: rotateY(180deg);
    -webkit-transform-style: preserve-3d;
            transform-style: preserve-3d;
}

.container .front{
    -webkit-transform: rotateY(0deg);
            transform: rotateY(0deg);
    -webkit-transform-style: preserve-3d;
            transform-style: preserve-3d;
}

.container:hover .back{
  -webkit-transform: rotateY(0deg);
          transform: rotateY(0deg);
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
}

.container:hover .front{
  -webkit-transform: rotateY(-180deg);
          transform: rotateY(-180deg);
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
}

.front .inner p{
  font-size: 2rem;
  margin-bottom: 2rem;
  position: relative;
}

.front .inner p:after{
  content: '';
  width: 4rem;
  height: 2px;
  position: absolute;
  background: #C6D4DF;
  display: block;
  left: 0;
  right: 0;
  margin: 0 auto;
  bottom: -.75rem;
}

.front .inner span{
  color: rgba(255,255,255,0.7);
  font-family: 'Montserrat';
  font-weight: 300;
}

@media screen and (max-width: 64rem){
  .col{
    width: calc(33.333333% - 2rem);
  }
}

@media screen and (max-width: 48rem){
  .col{
    width: calc(50% - 2rem);
  }
}

@media screen and (max-width: 32rem){
  .col{
    width: 100%;
    margin: 0 0 2rem 0;
  }
}
</style>