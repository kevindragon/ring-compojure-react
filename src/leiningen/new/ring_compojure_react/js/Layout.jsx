import React from 'react';

import Nav from './component/Nav.jsx';

export default class Layout extends React.Component {
  render() {
    return (
      <div class="container">
        <Nav />
        <div class="playground">
          {this.props.children}
        </div>
      </div>
    );
  }
}
