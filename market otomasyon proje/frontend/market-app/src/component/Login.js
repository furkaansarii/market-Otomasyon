import React from 'react'
import { Link } from 'react-router-dom';

export default function Login() {
    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">

                        <h2 className="text-center">Giriş Yap</h2>
                        <div className="card-body">

                            <div class ="form-box">
                            <label className="form-label">Kullanıcı Adı :</label>
                                <div class="input-box">
                                    <i class="fa fa-envelope-o"></i>
                                    <input type="email"></input>
                                </div>  
                            </div>

                            <label className="form-label mt-3">Şifre :</label>
                            <div class="input-box">
                                
                                <i class="fa fa-key"></i>
                                <input type="password"></input>
                            </div>



                           






                            <Link to="/Home" className="btn btn-dark mt-2">Giriş Yap</Link>
                            

                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
