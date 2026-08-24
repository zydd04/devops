<template>
  <div class="signin">
    <h1>Sign In</h1>
    <form @submit.prevent="handleSubmit">
      <div>
        <label for="email">Email</label>
        <input id="email" v-model="email" type="email" required />
      </div>
      <div>
        <label for="password">Password</label>
        <input id="password" v-model="password" type="password" required />
      </div>
      <button type="submit" :disabled="loading">
        {{ loading ? '...' : 'Sign In' }}
      </button>
    </form>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const email = ref('')
const password = ref('')
const message = ref('')
const loading = ref(false)

async function handleSubmit() {
  message.value = ''
  loading.value = true
  try {
    const res = await fetch('/api/signin', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: email.value, password: password.value }),
    })
    if (!res.ok) throw new Error('Sign in failed')
    const data = await res.json()
    message.value = `Welcome back!`
    email.value = ''
    password.value = ''
  } catch (err) {
    message.value = 'Invalid email or password'
    console.error(err)
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.signin {
  max-width: 400px;
  margin: 2rem auto;
  padding: 1.5rem;
}
input {
  display: block;
  width: 100%;
  margin-bottom: 1rem;
  padding: 0.5rem;
}
button {
  padding: 0.5rem 1rem;
  background: #0687a4;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>