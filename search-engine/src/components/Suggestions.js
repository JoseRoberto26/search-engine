import React from 'react'

const Suggestions = (props) => {
    const options = props.results.map(r => (
        <li key={r.index}>
            {r.title}
            -
            {r.type}
        </li>
    ))
    return <ul>{options}</ul>
}

export default Suggestions