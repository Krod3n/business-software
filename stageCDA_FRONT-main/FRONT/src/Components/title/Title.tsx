import React from 'react'

type Props = {}

const Title = (props: any) => {

    const { title } = props

  return (
        <div className="movementTitleContainer">
            <h1 className='movementTitle'>{title}</h1>
        </div>
  )
}

export default Title