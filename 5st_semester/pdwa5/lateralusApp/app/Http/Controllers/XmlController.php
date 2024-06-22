<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Album;

class XmlController extends Controller
{
    public function generateXml(){
        $data = Album::all();
        print_r($data);

        return response()->view("data-xml", ['registers' => $data])->header('Content-Type', 'application/xml');
    }
}
