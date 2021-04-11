<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Barber Shop</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class=" flex flex-row h-screen bg-cover bg-center" style="background-image:url(img/background.png)">
    <div class="w-full md:max-w-md lg:max-w-full md:w-1/5 xl:w-3/12 px-6 lg:px-16 xl:px-12 flex items-center justify-center m-6 rounded-lg shadow-xl opacity-95"
         style="background: #d7d3c8">
        <div class="w-full h-100">
            <h1 class="text-xl md:text-2xl font-bold leading-tight mt-12" style="color: #c13832">Register account</h1>
            <p class="text-red-600 font-serif text-xl mt-6">${error}</p>
            <form class="mt-6" action="register" method="POST">
                <div class="mt-4">
                    <label class="block text-gray-700" style="color: #c13832" for="registerUserName">Username</label>
                    <input name="registerUserName" id="registerUserName" placeholder="Enter Name"
                           class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-yellow-700 focus:bg-white focus:outline-none"
                           autofocus autocomplete required>
                </div>
                <div class="mt-4">
                    <label class="block text-gray-700" style="color: #c13832" for="registerEmail">Email Address</label>
                    <input type="email" name="registerEmail" id="registerEmail" placeholder="Enter Email Address"
                           class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-yellow-700 focus:bg-white focus:outline-none"
                           autofocus autocomplete required>
                </div>
                <div class="mt-4">
                    <label class="block text-gray-700" style="color: #c13832" for="registerPassword">Password</label>
                    <input type="password" name="registerPassword" id="registerPassword" placeholder="Enter Password"
                           class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-yellow-700 focus:bg-white focus:outline-none"
                           required>
                </div>
                <div class="mt-4">
                    <label class="block text-gray-700" style="color: #c13832" for="registerConfirmPassword">Confirm
                        Password</label>
                    <input type="password" name="registerConfirmPassword" id="registerConfirmPassword"
                           placeholder="Enter Password Again"
                           class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-yellow-700 focus:bg-white focus:outline-none"
                           autofocus autocomplete required>
                </div>
                <button type="submit"
                        class="w-full block bg-indigo-500 hover:bg-indigo-400 focus:bg-indigo-400 text-white font-semibold rounded-lg px-4 py-3 mt-6"
                        style="background: #4d4e53; color: #ff7800">Register
                </button>
            </form>
            <hr class="my-6 border-gray-300 w-full">
        </div>
    </div>
    <div class="w-4/5 xl:w-10/12">
    </div>
</div>
</body>
</html>

