import { createStore } from 'vuex';
import VuexPersist from 'vuex-persist';
import router from '@/router/index.js';
import { userLoginReq } from '../services';
import { ElMessage } from 'element-plus'
const warn = (inf) => {
  ElMessage({
    showClose: true,
    message: inf,
    type: 'error',
  })
}

const vuexLocalStorage = new VuexPersist({
    key: 'vuex', // The key to store the state on in the storage provider.
    storage: window.localStorage, // or window.sessionStorage or localForage
    // Function that passes the state and returns the state with only the objects you want to store.
    // reducer: state => state,
    // Function that passes a mutation and lets you decide if it should update the state in localStorage.
    // filter: mutation => (true)
})

const store = createStore({
    state(){
        return {
            loggedIn : false,
            account: "11",
            jwtToken: "",
            id : 0
        }
    },
    mutations: {
        loginSave(state, {account, jwtToken, id}){
            state.account = account,
            state.jwtToken = jwtToken,
            state.loggedIn = true,
            state.id = id
        }
    },
    actions:{
        login({commit}, {account, password}){
            userLoginReq(account, password)
            .then((res) => {
                var jwtToken = res.data.token;
                var id = res.data.id;
                console.log("Account:"+ account + "\nToken:" + jwtToken + "\nId:"+id)
                commit('loginSave',  { account, jwtToken, id})
                router.push('/userhome/' + id)
            }
            ).catch(error => {
              warn("登陆失败！信息不匹配。")
              console.error('There was an error!', error);
            });
        }
    },
    plugins: [vuexLocalStorage.plugin]
});

export {store}
