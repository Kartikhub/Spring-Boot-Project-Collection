// File: package.json
{
  "name": "ecommerce-frontend",
  "version": "1.0.0",
  "scripts": {
    "dev": "vite",
    "build": "tsc && vite build",
    "serve": "vite preview"
  },
  "dependencies": {
    "react": "^17.0.2",
    "react-dom": "^17.0.2",
    "react-router-dom": "^6.2.1",
    "axios": "^0.24.0",
    "keycloak-js": "^15.0.2"
  },
  "devDependencies": {
    "@types/react": "^17.0.33",
    "@types/react-dom": "^17.0.10",
    "@vitejs/plugin-react": "^1.0.7",
    "autoprefixer": "^10.4.2",
    "postcss": "^8.4.5",
    "tailwindcss": "^3.0.15",
    "typescript": "^4.4.4",
    "vite": "^2.7.2"
  }
}

// File: tsconfig.json
{
  "compilerOptions": {
    "target": "ESNext",
    "useDefineForClassFields": true,
    "lib": ["DOM", "DOM.Iterable", "ESNext"],
    "allowJs": false,
    "skipLibCheck": false,
    "esModuleInterop": false,
    "allowSyntheticDefaultImports": true,
    "strict": true,
    "forceConsistentCasingInFileNames": true,
    "module": "ESNext",
    "moduleResolution": "Node",
    "resolveJsonModule": true,
    "isolatedModules": true,
    "noEmit": true,
    "jsx": "react-jsx"
  },
  "include": ["src"],
  "references": [{ "path": "./tsconfig.node.json" }]
}

// File: tsconfig.node.json
{
  "compilerOptions": {
    "composite": true,
    "module": "esnext",
    "moduleResolution": "node"
  },
  "include": ["vite.config.ts"]
}

// File: vite.config.ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
})

// File: postcss.config.js
module.exports = {
  plugins: {
    tailwindcss: {},
    autoprefixer: {},
  },
}

// File: tailwind.config.js
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}

// File: src/index.css
@import 'tailwindcss/base';
@import 'tailwindcss/components';
@import 'tailwindcss/utilities';

// File: src/main.tsx
import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import App from './App'

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
)

// File: src/App.tsx
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import Signup from './pages/Signup';
import Login from './pages/Login';
import ProductCatalog from './pages/ProductCatalog';
import Cart from './pages/Cart';
import { AuthProvider } from './contexts/AuthContext';

const App: React.FC = () => {
  return (
    <AuthProvider>
      <Router>
        <div className="min-h-screen bg-gray-100">
          <Navbar />
          <main className="container mx-auto py-4">
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/login" element={<Login />} />
              <Route path="/products" element={<ProductCatalog />} />
              <Route path="/cart" element={<Cart />} />
            </Routes>
          </main>
        </div>
      </Router>
    </AuthProvider>
  );
};

export default App;

// File: src/contexts/AuthContext.tsx
import React, { createContext, useState, useEffect, useContext } from 'react';
import Keycloak from 'keycloak-js';

interface AuthContextType {
  keycloak: Keycloak | null;
  authenticated: boolean;
}

const AuthContext = createContext<AuthContextType>({ keycloak: null, authenticated: false });

export const AuthProvider: React.FC = ({ children }) => {
  const [keycloak, setKeycloak] = useState<Keycloak | null>(null);
  const [authenticated, setAuthenticated] = useState(false);

  useEffect(() => {
    const keycloak = new Keycloak({
      url: 'http://localhost:8180/auth',
      realm: 'ecommerce',
      clientId: 'ecommerce-app'
    });

    keycloak.init({ onLoad: 'check-sso' }).then(auth => {
      setKeycloak(keycloak);
      setAuthenticated(auth);
    });
  }, []);

  return (
    <AuthContext.Provider value={{ keycloak, authenticated }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);

// File: src/components/Navbar.tsx
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';

const Navbar: React.FC = () => {
  const { keycloak, authenticated } = useAuth();

  return (
    <nav className="bg-blue-600 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <Link to="/" className="text-2xl font-bold">E-commerce Store</Link>
        <div>
          <Link to="/products" className="mr-4">Products</Link>
          <Link to="/cart" className="mr-4">Cart</Link>
          {authenticated ? (
            <button onClick={() => keycloak?.logout()} className="bg-red-500 px-4 py-2 rounded">Logout</button>
          ) : (
            <>
              <Link to="/login" className="mr-4">Login</Link>
              <Link to="/signup" className="bg-green-500 px-4 py-2 rounded">Sign Up</Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

// File: src/pages/Home.tsx
import React from 'react';

const Home: React.FC = () => {
  return (
    <div className="text-center">
      <h1 className="text-4xl font-bold mb-4">Welcome to Our E-commerce Store</h1>
      <p className="text-xl">Find the best products at the best prices!</p>
    </div>
  );
};

export default Home;

// File: src/pages/Signup.tsx
import React, { useState } from 'react';
import axios from 'axios';

const Signup: React.FC = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/users/signup', { username, email, password });
      alert('Signup successful! Please login.');
    } catch (error) {
      console.error('Signup failed:', error);
      alert('Signup failed. Please try again.');
    }
  };

  return (
    <div className="max-w-md mx-auto">
      <h2 className="text-2xl font-bold mb-4">Sign Up</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label htmlFor="username" className="block mb-1">Username</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="w-full px-3 py-2 border rounded"
            required
          />
        </div>
        <div>
          <label htmlFor="email" className="block mb-1">Email</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full px-3 py-2 border rounded"
            required
          />
        </div>
        <div>
          <label htmlFor="password" className="block mb-1">Password</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full px-3 py-2 border rounded"
            required
          />
        </div>
        <button type="submit" className="w-full bg-blue-500 text-white py-2 rounded">Sign Up</button>
      </form>
    </div>
  );
};

export default Signup;

// File: src/pages/Login.tsx
import React from 'react';
import { useAuth } from '../contexts/AuthContext';

const Login: React.FC = () => {
  const { keycloak } = useAuth();

  const handleLogin = () => {
    keycloak?.login();
  };

  return (
    <div className="max-w-md mx-auto text-center">
      <h2 className="text-2xl font-bold mb-4">Login</h2>
      <button onClick={handleLogin} className="bg-blue-500 text-white py-2 px-4 rounded">
        Login with Keycloak
      </button>
    </div>
  );
};

export default Login;

// File: src/pages/ProductCatalog.tsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';

interface Product {
  id: number;
  name: string;
  price: number;
  description: string;
}

const ProductCatalog: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/products');
        setProducts(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching products:', error);
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  if (loading) {
    return <div>Loading products...</div>;
  }

  return (
    <div>
      <h2 className="text-2xl font-bold mb-4">Product Catalog</h2>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {products.map((product) => (
          <div key={product.id} className="border p-4 rounded">
            <h3 className="text-xl font-semibold">{product.name}</h3>
            <p className="text-gray-600">{product.description}</p>
            <p className="text-lg font-bold mt-2">${product.price.toFixed(2)}</p>
            <button className="mt-2 bg-blue-500 text-white py-1 px-2 rounded">Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductCatalog;

// File: src/pages/Cart.tsx
import React, { useState } from 'react';
import { useAuth } from '../contexts/AuthContext';
import axios from 'axios';

interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

const Cart: React.FC = () => {
  const [cartItems, setCartItems] = useState<CartItem[]>([]);
  const { authenticated } = useAuth();

  const totalAmount = cartItems.reduce((total, item) => total + item.price * item.quantity, 0);

  const handleCheckout = async () => {
    if (!authenticated) {
      alert('Please login to complete your purchase.');
      return;
    }

    try {
      const order = {
        items: cartItems.map(item => ({ productId: item.id, quantity: item.quantity })),
        totalAmount
      };

      await axios.post('http://localhost:8080/api/orders', order);
      alert('Order placed successfully!');
      setCartItems([]);
    } catch (error) {
      console.error('Error placing order:', error);
      alert('Failed to place order. Please try again.');
    }
  };

  return (
    <div>
      <h2 className="text-2xl font-bold mb-4">Your Cart</h2>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <>
          <ul className="space-y-2">
            {cartItems.map((item) => (
              <li key={item.id} className="flex justify-between items-center">
                <span>{item.name} (x{item.quantity})</span>
                <span>${(item.price * item.quantity).toFixed(2)}</span>
              </li>
            ))}
          </ul>
          <div className="mt-4">
            <p className="text-xl font-bold">Total: ${totalAmount.toFixed(2)}</p>
            <button
              onClick={handleCheckout}
              className="mt-2 bg-green-500 text-white py-2 px-4 rounded"
            >
              Checkout
            </button>
          </div>
        </>
      )}
    </div>
  );
};

export default Cart;
