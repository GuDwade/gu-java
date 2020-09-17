"use strict";   

function apiGet(url) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open("get", url);
        xhr.onload = function (ev) {
            if (xhr.status !== 200) {
                reject(xhr.responseText);  
                return;
            }
            let result = JSON.parse(xhr.responseText);
            if (result.status !== 200) {   
                reject(result.reason);  
            } else {
                resolve(result.data);   
            }
        };
        xhr.onerror = function (ev) {
            reject(xhr.responseText);   
        };
        xhr.send();
    });
}

function apiPost(url, data) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open("post", url);
        xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
        xhr.onload = function (ev) {
            if (xhr.status !== 200) {
                reject(xhr.responseText);  
                return;
            }
            let result = JSON.parse(xhr.responseText);
            if (result.status !== 200) {    
                reject(result.reason);  
            } else {
                resolve(result.data);  
            }
        };
        xhr.onerror = function (ev) {
            reject(xhr.responseText);  
        };
        xhr.send(JSON.stringify(data));
    });
}