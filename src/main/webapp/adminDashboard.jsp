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
    if (session.getAttribute("userRights").equals("Customer")) {
        response.sendRedirect("/dashboard");
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
                <a href="/adminDashboard"
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
                <a href="/adminBookingInformation"
                   class="flex items-center space-x-3 p-2 rounded-md font-medium hover:bg-gray-200 focus:bg-gray-200 focus:shadow-outline text-xl"
                   style="color: #c13832">
                    <span>
                        <svg class="h-5" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"></path>
                        </svg>
                    </span>
                    <span>Booked dates</span>
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
    <div class="w-4/5 xl:w-10/12">
    </div>
</div>
</body>
</html>