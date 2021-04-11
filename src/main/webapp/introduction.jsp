<%@ page import="com.janosSuli.barberShop.model.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Barber Shop</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("/login");
    }
%>

<div class=" flex flex-row h-screen bg-cover bg-center" style="background-image:url(img/background.png)">
    <div class="w-full md:max-w-md lg:max-w-full md:w-1/5 xl:w-3/12 px-6 lg:px-16 xl:px-12 flex flex-col m-6 rounded-lg shadow-xl opacity-95"
         style="background: #d7d3c8">
        <div class="flex items-center space-x-4 p-2 mt-5 mb-5 border-2 shadow-lg rounded-lg border-gray-600">
            <img class="h-12 rounded-full" src="img/blank-portrait.png" alt="placeholder">
            <div>
                <h4 class="font-semibold text-2xl capitalize font-poppins tracking-wide"
                    style="color: #c13832">${userName}</h4>
                <span class="text-sm tracking-wide flex items-center space-x-1">
                    <svg class="h-4 text-green-500" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M9 12l2 2 4-4m5.618-4.016A11.955 11.955 0 0112 2.944a11.955 11.955 0 01-8.618 3.04A12.02 12.02 0 003 9c0 5.591 3.824 10.29 9 11.622 5.176-1.332 9-6.03 9-11.622 0-1.042-.133-2.052-.382-3.016z"/>
                    </svg><span class=" text-base" style="color: #c13832">${userRights}</span>
                </span>
            </div>
        </div>
        <ul class="space-y-2 text-sm">
            <li>
                <a href="/dashboard"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M9.75 17L9 20l-1 1h8l-1-1-.75-3M3 13h18M5 17h14a2 2 0 002-2V5a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"/>
                        </svg>
                    </span>
                    <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="/introduction"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z"></path>
                        </svg>
                    </span>
                    <span>Introduction</span>
                </a>
            </li>
            <li>
                <a href="/barbers"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"/>
                        </svg>
                    </span>
                    <span>Barbers</span>
                </a>
            </li>
            <li>
                <a href="/booking"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"></path>
                        </svg>
                    </span>
                    <span>Booking</span>
                </a>
            </li>
            <li>
                <a href="/myProfile"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M12 6V4m0 2a2 2 0 100 4m0-4a2 2 0 110 4m-6 8a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4m6 6v10m6-2a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4"></path>
                        </svg>
                    </span>
                    <span>My profile</span>
                </a>
            </li>
            <li>
                <a href="/logout"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"/>
                        </svg>
                    </span>
                    <span>Logout</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="w-4/5 xl:w-10/12 mr-6 mt-6 mb-6 rounded-lg shadow-xl font-bold"
         style="background: #d7d3c8; color: #c13832">
        <h2 class=" text-center p-10 text-3xl">Lore ipsum</h2>
        <p class=" text-justify p-10 tracking-wider leading-7">Lorem ipsum dolor sit amet, consectetur adipiscing elit,
            sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua. Libero justo laoreet sit amet cursus sit. Sit amet consectetur adipiscing elit. Ligula
            ullamcorper malesuada proin libero nunc consequat interdum varius. Ut morbi tincidunt augue interdum velit
            euismod. Integer enim neque volutpat ac tincidunt vitae semper quis. Accumsan in nisl nisi scelerisque eu
            ultrices vitae auctor eu. Egestas tellus rutrum tellus pellentesque eu. Sed adipiscing diam donec adipiscing
            tristique risus. Ut enim blandit volutpat maecenas volutpat blandit. Amet justo donec enim diam vulputate ut
            pharetra sit. Cras fermentum odio eu feugiat pretium. Turpis tincidunt id aliquet risus feugiat in ante.
            Quis ipsum suspendisse ultrices gravida dictum fusce ut. Pretium quam vulputate dignissim suspendisse. Ac
            turpis egestas sed tempus urna et pharetra pharetra.

            Lacus laoreet non curabitur gravida. Mattis pellentesque id nibh tortor. Dolor sit amet consectetur
            adipiscing elit. Egestas maecenas pharetra convallis posuere morbi leo. Velit aliquet sagittis id
            consectetur purus ut faucibus pulvinar elementum. Vivamus at augue eget arcu dictum varius duis at. Fusce ut
            placerat orci nulla pellentesque. Amet nulla facilisi morbi tempus iaculis urna id volutpat. Dictum varius
            duis at consectetur. Et malesuada fames ac turpis. Pulvinar pellentesque habitant morbi tristique senectus
            et netus. Magna fringilla urna porttitor rhoncus dolor purus non enim. Vitae semper quis lectus nulla at
            volutpat diam ut. Praesent elementum facilisis leo vel fringilla. Augue neque gravida in fermentum et
            sollicitudin ac orci phasellus. Egestas purus viverra accumsan in. Diam donec adipiscing tristique risus
            nec.</p>
    </div>
</div>
</body>
</html>