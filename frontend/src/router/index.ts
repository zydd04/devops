import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/dashboard', name: 'dashboard', component: () => import('../views/Dashboard.vue') },
    { path: '/signup', name: 'signup', component: () => import('../views/Signup.vue') },
    { path: '/signin', name: 'signin', component: () => import('../views/Signin.vue')},
  ],
})

export default router