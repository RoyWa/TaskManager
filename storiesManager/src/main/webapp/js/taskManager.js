

class Board extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            isCardFaceFront:true
        };
    }

    componentDidUpdate(){
        TweenLite.set('.cardWrapper', {perspective: 800});
        TweenLite.set('.card', {transformStyle: 'preserve-3d'});
        TweenLite.set('.back', {rotationY: -180});
        TweenLite.set(['.back', '.front'], {backfaceVisibility: 'hidden'});
        //var $this = $(ReactDOM.findDOMNode(this));
    }
    
    handleFlipClick(objId){
        const card = $("div[data-id='"+objId+"']");
        const rotationDegree = (this.state.isCardFaceFront) ? 180 : 0;
        TweenLite.to(card, 1.2, {rotationY:rotationDegree, ease:Back.easeOut});
        this.setState({
            isCardFaceFront: !this.state.isCardFaceFront
        });
    }

    renderBoard() {
        if ( this.props.stories.map) {
            const stories = this.props.stories.map((story, step) => {
                const num = story.number;
                const desc = story.short_description;
                return (  <div key={step}>
                            <div className="cardWrapper answer-animation"  >
                                <div className="card" data-id={"card_"+ step} onClick={() => this.handleFlipClick("card_"+ step) } >
                                    <div className="cardFace front" ><h1>(-: </h1></div>
                                    <div className="cardFace back"  ><h1>{num} - {desc}</h1></div>
                                </div>
                            </div>
                         </div>
                );
            });
            return ( <div>{stories}</div>);
        } 
        return '';
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
    document.getElementById('root'),
);
