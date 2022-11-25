import React from 'react'


export default function Menu() {
    return (
        <container>
        <div>
            <div class="list-group mt-5 ">
                <a href="/products" class="list-group-item list-group-item-action" aria-current="true">
                    Ürünler
                </a>
                <a href="/wholesaler" class="list-group-item list-group-item-action">Toptancılar</a>
                <a href="/productSales" class="list-group-item list-group-item-action">Satılan Ürünler</a>
                <a href="/employee" class="list-group-item list-group-item-action">Çalışanlar</a>
                
            </div>
        </div>
        </container>
    )
}
