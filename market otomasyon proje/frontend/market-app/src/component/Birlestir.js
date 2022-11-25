import React from 'react'

import Menu from './Menu'
import ListProductComponent from './product/ListProductComponent'

export default function Birlestir() {
  return (
    <div class="container">
    <div class="row row-cols-auto">
        <div class="col-2"><Menu></Menu> </div>
        <div class="col-10"><ListProductComponent></ListProductComponent></div>

    </div>
</div>

  )
}
