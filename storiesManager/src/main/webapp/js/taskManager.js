
function flip(obj){
  TweenLite.to($(this).find(".card"), 1.2, {rotationY:180, ease:Back.easeOut})
}

class Board extends React.Component {
    renderBoard() {
        if ( this.props.stories.map) {
            TweenLite.set('.cardWrapper', {perspective: 800});
            TweenLite.set('.card', {transformStyle: 'preserve-3d'});
            TweenLite.set('.back', {rotationY: -180});
            TweenLite.set(['.back', '.front'], {backfaceVisibility: 'hidden'});

            const stories = this.props.stories.map((story, step) => {
                const num = story.number;
                const desc = story.short_description;
                return (  <div key={step}>
                            <div className="cardWrapper answer-animation"  onClick={() => flip(this) } >
                                <div className="card" >
                                    <div className="cardFace front" ><h1>(-: </h1></div>
                                    <div className="cardFace back"  ><h1>{num} - {desc}</h1></div>
                                </div>
                            </div>
                         </div>
                );
            });
            return ( <div>{stories}</div>);
        } 
        return 'bbb';
    }
    
    render() {
        return <div>{this.renderBoard()}</div>;
    }
}

class TaskManager extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            stories:{}
        };

        fetch('/stories').then(response => response.json()).then((stories) => {
            this.setState({
                stories: stories
            });
        });
    }

    render(){
        return <Board stories={this.state.stories} />
    }
} 

ReactDOM.render(
    <TaskManager />,
    document.getElementById('root')
);
