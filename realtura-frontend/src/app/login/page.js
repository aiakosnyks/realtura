// pages/login.js
'use client'
import { useState } from 'react';
import { useRouter } from 'next/navigation';
import { toast } from 'react-toastify';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [userId, setUserId] = useState(null);
    const router = useRouter();

    const handleLogin = async (e) => {
        e.preventDefault();
        console.log('handleLogin')
        try {
            const response = await fetch('http://localhost:8091/api/v1/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });
            const res = await response.json();
            console.log('resjson:', JSON.stringify(res, null, 2)); // Improved logging

            if (response.ok) {
                console.log('ok');
                if (res.status ==='SUCCESS') {
                    console.log('success');
                    setUserId(data.id); // Assuming response.data.id contains the user ID
                    toast.success('Login successful!');
                    return router.push('/deneme');
                } else {
                    toast.error('Login failed: ' + (data.message || 'Unknown error'));
                }
            } else {
                toast.error('Login failed: ' + (data.message || 'Unknown error'));
            }
        } catch (error) {
            toast.error('An error occurred: ' + (error.message || 'Unknown error'));
        }
    };

    return (
        <div>
            <h1>Login</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email:</label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                <button type="submit">Login</button>
            </form>
            {userId && <p>User ID: {userId}</p>}
        </div>
    );
};

export default Login;
