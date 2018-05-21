class Task extends React.Component {
    render() {
        return <div>aaaa</div>;
    }
}

class Board extends React.Component {
    render() {
        return <div> <Task /></div>;
    }
}

class TaskManager extends React.Component {
    constructor(props){
        super(props);
    }

    render(){
        return <Board />
    }
} 

ReactDOM.render(
    <TaskManager />,
    document.getElementById('root')
);