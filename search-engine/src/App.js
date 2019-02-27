import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
import logo from './assets/jus_logo.jpg';
import Suggestions from './components/Suggestions';

class App extends Component {

constructor(props){
    super(props);
        this.state = {
        itemToSave: {title: '', type:''},
        allItems:[],
        itemsFound: [],
        typeFilter: '',
        titleFilter: '',
    }
}



getAll(){
    const baseURL = 'http://localhost:8080/entities/all';
    let encodedURI = window.encodeURI(baseURL);
    axios.get(encodedURI).then(response =>{
        console.log(response.data.content);
        this.setState({allItems: response.data.content});
    })
}

    componentDidMount(){
        this.getAll();
    }



    saveItem(){
    const baseURL = 'http://localhost:8080/entities';
    let encodedURI = window.encodeURI(baseURL);
    this.state.allItems.push(this.state.itemToSave);
        axios.post(encodedURI, this.state.allItems).then(response => {
        }).catch(error => {
            console.log(error);
        })
    }

    getItems = (e) => {

        this.setState({titleFilter: e.target.value});

        if (e.target.value === '' || e.target.value === null) {
            this.setState({itemsFound: []});
        }

        else {
            if (this.state.typeFilter === '' || this.state.typeFilter === null) {
                const baseURL = 'http://localhost:8080/entities/?q=' + e.target.value;
                let encodedURI = window.encodeURI(baseURL);
                axios.get(encodedURI).then(response => {
                    this.setState({itemsFound: response.data});
                    console.log(response);
                })
            }
            else {
                const baseURL = 'http://localhost:8080/entities/?q=' + e.target.value + '&entity_type=' + this.state.typeFilter;
                let encodedURI = window.encodeURI(baseURL);
                axios.get(encodedURI).then(response => {
                    this.setState({itemsFound: response.data});
                    console.log(response);
                })
            }
        }
    }
    getItemsWithType = (e) =>{
       this.setState({typeFilter: e.target.value});
        const baseURL = 'http://localhost:8080/entities/?q=' + this.state.titleFilter + '&entity_type=' + e.target.value;
        let encodedURI = window.encodeURI(baseURL);
        axios.get(encodedURI).then(response => {
            this.setState({itemsFound: response.data});
            console.log(response);
        })
    }

    setItemToSaveName = (e) =>{
        let itemType = this.state.itemToSave.type;
        this.setState({itemToSave: {title : e.target.value, type: itemType}});
        console.log(this.state);
    }

    setItemToSaveType = (e) =>{
        let itemName = this.state.itemToSave.title;
        this.setState({itemToSave: {title : itemName,type : e.target.value}});
        console.log(this.state);
    }


  render() {
    return (
      <div className="App">

          <main className="container">

          <img className="logo" alt="" src={logo}/>
          <h1 className="title">Jusbrasil Search Engine</h1>

          <div className="searchForm">

              <div className="input-box">
            <input className="searchInput" onChange={this.getItems.bind(this)} type="text" placeholder="Title"/>

              </div>

              <div className="input-box">
              <input className="searchInput" onChange={this.getItemsWithType.bind(this)} type="text" placeholder="Type"/>

              </div>


          </div>
              <div className="suggestions-box">
              <Suggestions results={this.state.itemsFound}/>
              </div>

              <h3>Salvar novo item</h3>
              <div className="creationForm">

                  <div className="input-box">
                  <input className="searchInput" onChange={this.setItemToSaveName.bind(this)} type="text" placeholder="Title"/>

                  </div>

                  <div className="input-box">
                  <input className="searchInput" onChange={this.setItemToSaveType.bind(this)} type="text" placeholder="Type"/>

                  </div>
              </div>
              <button className="button" onClick={this.saveItem.bind(this)}>Salvar</button>

          </main>
      </div>
    );
  }
}

export default App;
