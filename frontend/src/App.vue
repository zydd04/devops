<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const isLoggedIn = ref(!!localStorage.getItem('userEmail'))

function logout() {
  localStorage.removeItem('userEmail')
  isLoggedIn.value = false
  router.push('/')
}
</script>

<template>
  <nav>
    <template v-if="!isLoggedIn">
      <router-link to="/signup">Sign Up</router-link>
      <router-link to="/signin">Sign In</router-link>
    </template>
    <template v-else>
      <a href="#" @click.prevent="logout">Logout</a>
    </template>
  </nav>
  <router-view />
</template>

<style scoped>
nav {
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
  padding: 1rem;
}
</style>